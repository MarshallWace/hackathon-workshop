from dataclasses import dataclass
from pathlib import Path

from mws.pipeline import Pipeline
from mws.sinks import CallbackSink
from mws.sources import CSVSource
from mws.operators import Map, FlatMap, Filter


EXPECTED = ["love", "edinburgh", "bitcoin", "edinburgh", "memes", "better"]


@dataclass
class Tweet:
    id: int
    contents: str


def test_word_cleaning() -> None:
    output = []
    sink = CallbackSink(output.append)
    source = CSVSource(Tweet, Path(__file__).with_name("tweets.csv"))

    pipeline = ...

    pipeline.start()
    assert output == EXPECTED
