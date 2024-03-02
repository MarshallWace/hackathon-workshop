import sys

from typing import TypeVar

from mws.operators.operator import Sink


T = TypeVar("T")


class ConsoleSink(Sink[T]):
    """
    A sink that prints all input events to the console.
    """

    def __init__(self, prefix: str = "") -> None:
        super().__init__()
        self.prefix = prefix

    def consume(self, event: T) -> None:
        print(self.prefix + str(event))
