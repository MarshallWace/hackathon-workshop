from typing import List, TypeVar, Generic

from abc import ABC, abstractmethod


I = TypeVar("I")
O = TypeVar("O")


class Operator(ABC, Generic[I, O]):
    """
    An operator in the dataflow graph.
    """

    def __init__(self) -> None:
        self.children: List[Operator] = []
        ...

    @abstractmethod
    def consume(self, event: I) -> None:
        """
        Process some event and send the result downstream.
        """
        ...

    def add_child(self, child: "Operator") -> None:
        """
        Register a child (downstream node) to the operator.
        """
        self.children.append(child)

    def to(self, sink: "Sink") -> "Operator":
        self.add_child(sink)
        return sink

    def flush(self) -> None:
        """
        Emit any parially processed events (e.g. open windows) and
        flush downstream nodes.
        """
        for child in self.children:
            child.flush()

    def emit(self, event: O) -> None:
        for child in self.children:
            child.consume(event)


class Source(Operator[None, O]):
    """
    A source operator in a dataflow graph (one which produces values).
    """

    def __init__(self) -> None:
        super().__init__()

    @abstractmethod
    def start(self) -> None:
        """
        Begin producing values.
        """
        ...

    def consume(self, event) -> None:
        raise Exception(
            "source doesn't implement consume - no downstream nodes to read from"
        )


class Sink(Operator[I, None]):
    """
    A sink in a dataflow graph (a terminal node).
    """

    def __init__(self) -> None:
        super().__init__()

    @abstractmethod
    def consume(self, event: I) -> None: ...

    def add_child(self, child: Operator) -> None:
        raise Exception("a sink node cannot have children")

    def emit(self, event: None) -> None:
        raise Exception("a sink node cannot emit events")
