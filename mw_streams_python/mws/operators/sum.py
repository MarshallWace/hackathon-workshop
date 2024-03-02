from typing import TypeVar

from numbers import Number

from mws.operators.operator import Operator


class Sum(Operator[Number, Number]):
    def __init__(self) -> None:
        super().__init__()
        self.total = 0

    def consume(self, event: Number) -> None:
        self.total += event
        self.emit(self.total)
