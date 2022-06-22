package petclinic

import petclinic.server._
import petclinic.services._
import zio._

object Main extends ZIOAppDefault {

  override val run: Task[Unit] =
    ZIO
      .serviceWithZIO[ClinicServer](_.start)
      .provide(
        ClinicServer.layer,
        PetRoutes.layer,
        VetRoutes.layer,
        OwnerRoutes.layer,
        VisitRoutes.layer,
        QuillContext.dataSourceLayer,
        OwnerServiceLive.layer,
        PetServiceLive.layer,
        VetServiceLive.layer,
        VisitServiceLive.layer,
        Migrations.layer
      )

}
