from typing import TypeVar, Iterable

from mws.operators.operator import Source


T = TypeVar("T")


class IterSource(Source[T]):
    def __init__(self, items: Iterable[T]) -> None:
        super().__init__()
        self.items = items

    def start(self) -> None:
        for item in self.items:
            self.emit(item)

        #
        self.flush()
