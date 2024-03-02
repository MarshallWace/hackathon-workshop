from mws.operators import Map
from mws.sources import IterSource
from mws.sinks import CallbackSink
from mws.pipeline import Pipeline

SOURCE = IterSource(range(1, 20))
EXPECTED = [
    "1",
    "2",
    "fizz",
    "4",
    "buzz",
    "fizz",
    "7",
    "8",
    "fizz",
    "buzz",
    "11",
    "fizz",
    "13",
    "14",
    "fizzbuzz",
    "16",
    "17",
    "fizz",
    "19",
]


def fizzbuzz(n: int) -> str:
    if n % 5 == 0 and n % 3 == 0:
        return "fizzbuzz"
    elif n % 3 == 0:
        return "fizz"
    elif n % 5 == 0:
        return "buzz"
    else:
        return str(n)


def test_fizzbuzz() -> "Pipeline[int, str]":
    """
    Implement a fizzbuzz pipeline (hint: `Map` will be a helpful operator).
    """
    output = []
    sink = CallbackSink(output.append)

    pipeline = Pipeline.of(SOURCE).then(Map(fizzbuzz)).to(sink)
    pipeline.start()

    assert output == EXPECTED
