from numbers import Number

from mws.operators.operator import Operator


class Average(Operator[Number, Number]):
    def __init__(self) -> None:
        super().__init__()
        self.sum = 0.0
        self.count = 0

    def consume(self, event: Number) -> None:
        self.sum += event
        self.count += 1

        self.emit(self.sum / self.count)
