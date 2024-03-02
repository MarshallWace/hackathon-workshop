from dataclasses import dataclass
from pathlib import Path

from mws.pipeline import Pipeline
from mws.operators import Map, Sum
from mws.sinks import CallbackSink
from mws.sources import CSVSource


EXPECTED = [
    1,
    2,
    3,
    2,
    3,
    4,
    3,
    2,
    3,
    4,
    5,
    4,
    5,
    4,
    3,
    4,
    5,
    6,
    7,
    6,
    7,
    8,
    9,
    8,
    7,
    6,
    7,
    6,
]


@dataclass
class Event:
    message: str


def test_party_people() -> None:
    source = CSVSource(Event, Path(__file__).with_name("party_people.csv"))
    output = []
    sink = CallbackSink(output.append)

    pipeline = (
        Pipeline.of(source)
        .then(Map(lambda e: e.message.split(" ")[1]))
        .then(Map(lambda s: 1 if s == "arrival" else -1))
        .then(Sum())
        .to(sink)
    )

    pipeline.start()
    assert output == EXPECTED
