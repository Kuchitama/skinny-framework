import _root_.controller._
import org.scalatra.swagger.Swagger
import skinny._
import skinny.controller._
import skinny.session.SkinnySessionInitializer

class ScalatraBootstrap extends SkinnyLifeCycle {

  implicit val swagger = new Swagger("1.2", "1")

  override def initSkinnyApp(ctx: ServletContext) {

    scalikejdbc.GlobalSettings.loggingSQLAndTime = scalikejdbc.LoggingSQLAndTimeSettings(
      singleLineMode = true
    )
    ctx.mount(classOf[SkinnySessionInitializer], "/*")

    ErrorController.mount(ctx)

    Controllers.root.mount(ctx)
    Controllers.programmers().mount(ctx)
    Controllers.mail.mount(ctx)
    Controllers.customLayout.mount(ctx)
    Controllers.mustache.mount(ctx)
    Controllers.thymeleaf.mount(ctx)

    SkillsController.mount(ctx)
    CompaniesController.mount(ctx)
    CommentsController.mount(ctx)
    SnakeCaseKeyExamplesController.mount(ctx)

    AssetsController.mount(ctx)

    ctx.mount(new SwaggerApiDocsController(), "/api-docs/*")
  }

}
