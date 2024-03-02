from numbers import Number

from mws.operators.operator import Operator


class TumblingAverage(Operator[Number, Number]):
    def __init__(self, window_size: int) -> None:
        super().__init__()
        self.window_size = window_size
        self.sum = 0.0
        self.count = 0

    def consume(self, event: Number) -> None:
        self.sum += event
        self.count += 1

        # emit new average and reset if we've filled up our window
        if self.count >= self.window_size:
            window_avg = self.sum / self.count
            self.sum = 0
            self.count = 0

            self.emit(window_avg)
