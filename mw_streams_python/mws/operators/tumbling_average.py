from numbers import Number

from mws.operators.operator import Operator


class TumblingAverage(Operator[Number, Number]):
    def __init__(self, window_size: int) -> None:
        super().__init__()
        self.window_size = window_size
        self.sum = 0.0
        self.count = 0

    def consume(self, event: Number) -> None:
        raise NotImplementedError("TODO implement me")
