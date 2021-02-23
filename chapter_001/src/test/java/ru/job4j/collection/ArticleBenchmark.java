package ru.job4j.collection;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.VerboseMode;
import java.util.concurrent.TimeUnit;

public class ArticleBenchmark {

    @State(Scope.Benchmark)
    public static class St {
         public static Article article = new Article();
    }

    @Benchmark
    public void articleBenchmarkTest() {
            St.article.generateBy(
                    "Мой дядя самых честных правил, " +
                            "Когда не в шутку занемог, " +
                            "Он уважать себя заставил " +
                            "И лучше выдумать не мог. " +
                            "Его пример другим наука; " +
                            "Но, боже мой, какая скука " +
                            "С больным сидеть и день и ночь, " +
                            "Не отходя ни шагу прочь! " +
                            "Какое низкое коварство " +
                            "Полуживого забавлять, " +
                            "Ему подушки поправлять, " +
                            "Печально подносить лекарство, " +
                            "Вздыхать и думать про себя: " +
                            "Когда же черт возьмет тебя!",
                    "Мой дядя мог думать про Linux и Java день и ночь"
            );
    }

    @Benchmark
    public void articleBenchmarkTest2() {
        St.article.generateBy(
                "Мама мыла раму и окно",
                "мыла окно"
        );
    }

    @Test
    public void startBenchmark() throws RunnerException {
        Options options = new OptionsBuilder()
                .include(ArticleBenchmark.class.getSimpleName())
                .mode(Mode.AverageTime)
                .verbosity(VerboseMode.EXTRA)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupTime(TimeValue.seconds(1))
                .measurementTime(TimeValue.milliseconds(1))
                .measurementIterations(2)
                .threads(4)
                .warmupIterations(2)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .forks(1)
                .build();
        new Runner(options).run();
    }
}
