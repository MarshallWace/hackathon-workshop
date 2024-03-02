from mws.operators.operator import Operator, Source, Sink


class Pipeline:
    def __init__(self, source: Operator) -> None:
        self.source = source
        self.head = source

    @staticmethod
    def of(source: Source) -> "Pipeline":
        return Pipeline(source=source)

    def then(self, operator: Operator) -> "Pipeline":
        self.head.add_child(operator)
        self.head = operator

        return self

    def to(self, sink: Sink) -> None:
        self.head.add_child(sink)
        self.head = sink

        return self

    def start(self) -> None:
        self.source.start()
