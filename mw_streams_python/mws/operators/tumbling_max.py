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
        raise NotImplementedError("TODO implement me")
