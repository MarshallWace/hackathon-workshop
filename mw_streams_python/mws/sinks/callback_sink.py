from typing import TypeVar, Generic, Callable

from mws.operators import Sink


T = TypeVar("T")


class CallbackSink(Sink[T]):
    def __init__(self, callback: Callable[[T], None]) -> None:
        super().__init__()
        self.callback = callback

    def consume(self, event: T) -> None:
        self.callback(event)
