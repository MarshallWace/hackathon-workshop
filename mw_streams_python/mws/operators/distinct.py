from typing import TypeVar, Callable

from mws.operators.operator import Operator


I = TypeVar("I")


class Distinct(Operator[I, I]):
    def __init__(self) -> None:
        super().__init__()
        self.seen: set[I] = set()

    def consume(self, event: I) -> None:
        if event not in self.seen:
            self.seen.add(event)
            self.emit(event)
