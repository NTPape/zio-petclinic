package petclinic.models.api

import zio.json._

/** Models the parameters of a post request that the client will send to the
  * server while removing the need for the request to handle generating an
  * OwnerId.
  */
final case class CreateOwner(firstName: String, lastName: String, email: String, phone: String, address: String)

/** Derives a JSON codec allowing the CreateOwner request to be (de)serialized.
  */
object CreateOwner {
  implicit val codec: JsonCodec[CreateOwner] =
    DeriveJsonCodec.gen[CreateOwner]
}
