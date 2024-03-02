from typing import TypeVar, Callable

from mws.operators.operator import Operator


I = TypeVar("I")
O = TypeVar("O")


class Max(Operator[I, O]):
    def __init__(self) -> None:
        super().__init__()
        self.curr_max = None

    def consume(self, event: I) -> None:
        if not self.curr_max or event > self.curr_max:
            self.curr_max = event

        self.emit(self.curr_max)
