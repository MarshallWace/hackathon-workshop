"""
Here's an example pipeline. Execute it to see what the output is.
"""

from mws.operators.map import Map
from mws.operators.filter import Filter
from mws.pipeline import Pipeline
from mws.sinks.console_sink import ConsoleSink
from mws.sources.iter_source import IterSource


def main() -> None:
    pipeline = (
        Pipeline.of(IterSource(range(10)))
        .then(Map(lambda x: x * x))
        .then(Filter(lambda x: x > 40))
        .to(ConsoleSink())
    )

    pipeline.start()


if __name__ == "__main__":
    main()
