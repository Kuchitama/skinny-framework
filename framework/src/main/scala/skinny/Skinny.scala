package skinny

/**
 * Global object for accessing Skinny common APIs & request scope attributes in views.
 */
case class Skinny(requestScope: collection.mutable.Map[String, Any]) {

  import skinny.controller.feature.RequestScopeFeature._

  def getAs[A](key: String): Option[A] = requestScope.get(key).map(_.asInstanceOf[A])

  def set(key: String, value: Any): Unit = requestScope.update(key, value)

  // getters are required for OGNL support (e.g. Thymeleaf template engine)

  def env: String = SkinnyEnv.get().orNull
  def getEnv = env

  def params: Params = getAs[Params](ATTR_PARAMS).orNull
  def getParams = params

  def multiParams: MultiParams = getAs[MultiParams](ATTR_MULTI_PARAMS).orNull
  def getMultiParams = multiParams

  def flash: Flash = getAs[Flash](ATTR_FLASH).orNull
  def getFlash = flash

  def errorMessages: Seq[String] = getAs[Seq[String]](ATTR_ERROR_MESSAGES).getOrElse(Nil)
  def getErrorMessages = errorMessages

  def keyAndErrorMessages: Map[String, Seq[String]] = getAs[Map[String, Seq[String]]](ATTR_KEY_AND_ERROR_MESSAGES).getOrElse(Map())
  def getKeyAndErrorMessages = keyAndErrorMessages

  def contextPath: String = getAs[String](ATTR_CONTEXT_PATH).orNull
  def getContextPath = contextPath

  def requestPath: String = getAs[String](ATTR_REQUEST_PATH).orNull
  def getRequestPath = requestPath

  def requestPathWithQueryString: String = getAs[String](ATTR_REQUEST_PATH_WITH_QUERY_STRING).orNull
  def getRequestPathWithQueryString = requestPathWithQueryString

  def csrfKey: String = getAs[String](ATTR_CSRF_KEY).orNull
  def getCsrfKey = csrfKey

  def csrfToken: String = getAs[String](ATTR_CSRF_TOKEN).orNull
  def getCsrfToken = csrfToken

  def csrfMetaTag: String = s"""<meta content="${csrfToken}" name="${csrfKey}" />"""
  def csrfMetaTags: String = csrfMetaTag // Rails compatible
  def getCsrfMetaTag = csrfMetaTag

  def csrfHiddenInputTag: String = s"""<input type="hidden" name="${csrfKey}" value="${csrfToken}"/>"""
  def getCsrfHiddenInputTag = csrfHiddenInputTag

  def i18n: I18n = getAs[I18n](ATTR_I18N).getOrElse(I18n())
  def getI18n = i18n

}
