from typing import TypeVar, Callable

from mws.operators.operator import Operator


I = TypeVar("I")


class Filter(Operator[I, I]):
    def __init__(self, predicate: Callable[[I], bool]) -> None:
        super().__init__()
        self.predicate = predicate

    def consume(self, event: I) -> None:
        if self.predicate(event):
            self.emit(event)
