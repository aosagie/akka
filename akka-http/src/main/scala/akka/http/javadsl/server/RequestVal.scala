/*
 * Copyright (C) 2009-2014 Typesafe Inc. <http://www.typesafe.com>
 */

package akka.http.javadsl.server

import akka.http.javadsl.server.values.{ PathMatcher, HttpBasicAuthenticator }

/**
 * Represents a value that can be extracted from a request.
 */
trait RequestVal[T] { outer ⇒
  /**
   * An accessor for the value given the [[RequestContext]].
   *
   * Note, that some RequestVals need to be actively specified in the route structure to
   * be extracted at a particular point during routing. One example is a [[PathMatcher]]
   * that needs to used with a [[directives.PathDirectives]] to specify which part of the
   * path should actually be extracted. Another example is an [[HttpBasicAuthenticator]]
   * that needs to be used in the route explicitly to be activated.
   */
  def get(ctx: RequestContext): T

  /**
   * The runtime type of the extracted value.
   */
  def resultClass: Class[T]
}
