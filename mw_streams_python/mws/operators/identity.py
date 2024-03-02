"""
sdjkf
"""

from typing import TypeVar

from mws.operators.operator import Operator


T = TypeVar("T")


class Identity(Operator[T, T]):
    """
    This class implements the identity operator which does nothing.
    """

    def __init__(self) -> None:
        """
        This is the constructor, which is called when the operator is created.
        If you need to pass in any variables or keep track of any state you
        should set it up here.
        """
        super().__init__()

    def consume(self, event: T) -> None:
        """
        `consume` is called each time we we recieve a new event. Here we would
        do any processing on the input, and then use `emit` to pass the output
        to any child operators.
        """
        self.emit(event)
