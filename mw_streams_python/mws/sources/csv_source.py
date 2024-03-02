from typing import TypeVar, Iterable

from csv import DictReader
from dataclasses import is_dataclass

from mws.operators.operator import Source


T = TypeVar("T")


class CSVSource(Source[T]):
    def __init__(self, row_class: type, filepath: str) -> None:
        super().__init__()

        if not is_dataclass(row_class):
            raise ValueError("")

        self.row_class = row_class
        self.filepath = filepath

    def _get_rows(self):
        with open(self.filepath, "r") as f:
            return [self.row_class(**row) for row in DictReader(f)]

    def start(self) -> None:
        rows = self._get_rows()
        for row in rows:
            self.emit(row)

        self.flush()
