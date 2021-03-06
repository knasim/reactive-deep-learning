package fp

/*
  def layerFeedForward(depth: Int): Seq[Double] =
    network(depth).map(_.apply(if(depth == 0) features else layerFeedForward(depth - 1), weights(depth), bias(depth)))

  val firstLayerOutput = network(0).map(_.apply(features, weights, bias(0)))
  network(1).map(_.apply(firstLayerOutput, weights, bias(1)))

  layerFeedForward(1)
*/

object Perceptron {
  def activation(w: Vector[Double], f: Vector[Double], bias: Double, activationFunction: Double => Double) =
    activationFunction(w.zip(f).map(x => x._1 * x._2).sum + bias)
}

object Network {
  def feedForward(features: Vector[Double], network: Seq[Vector[Vector[Double] => Double]]): Vector[Double] =
    network.foldLeft(features)((b, a) => a.map(_(b)))
}