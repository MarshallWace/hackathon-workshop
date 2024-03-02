from typing import Iterable, TypeVar, Callable

from mws.operators.operator import Operator


I = TypeVar("I")
O = TypeVar("O")


class FlatMap(Operator[I, O]):
    def __init__(self, fn: Callable[[I], Iterable[O]]) -> None:
        super().__init__()
        self.fn = fn

    def consume(self, event: I) -> None:
        raise NotImplementedError("TODO implement me")
