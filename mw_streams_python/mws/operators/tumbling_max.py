from typing import TypeVar

from mws.operators.operator import Operator


T = TypeVar("T")


class Max(Operator[T, T]):
    def __init__(self, window_size: int) -> None:
        super().__init__()
        self.count = 0
        self.curr_max = None
        self.window_size = window_size

    def consume(self, event: T) -> None:
        if not self.curr_max or event > self.curr_max:
            self.curr_max = event

        # emit max and reset if we've reached the end of our window
        if self.count >= self.window_size:
            self.count = 0
            self.curr_max = None
            self.emit(self.curr_max)
