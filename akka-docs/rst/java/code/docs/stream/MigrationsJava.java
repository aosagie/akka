/**
 * Copyright (C) 2015 Typesafe Inc. <http://www.typesafe.com>
 */
package docs.stream;

import java.util.stream.Stream;

import akka.japi.Pair;
import akka.stream.javadsl.*;
//#asPublisher-import
import static akka.stream.javadsl.AsPublisher.*;
//#asPublisher-import

public class MigrationsJava {

  public static void main(String[] args) {
    //#expand-continually
    Flow.of(Integer.class).expand(in -> Stream.iterate(in, i -> i).iterator());
    //#expand-continually
    //#expand-state
    Flow.of(Integer.class).expand(in ->
        Stream.iterate(new Pair<>(in, 0),
                       p -> new Pair<>(in, p.second() + 1)).iterator());
    //#expand-state
    
    //#asPublisher
    Sink.asPublisher(WITH_FANOUT);    // instead of Sink.asPublisher(true)
    Sink.asPublisher(WITHOUT_FANOUT); // instead of Sink.asPublisher(false)
    //#asPublisher
  }

}