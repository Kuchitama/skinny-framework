#!/bin/sh

sbt ++2.11.7 \
  clean \
  common/publishSigned \
  assets/publishSigned \
  httpClient/publishSigned \
  json/publishSigned \
  orm/publishSigned \
  factoryGirl/publishSigned \
  validator/publishSigned \
  framework/publishSigned \
  mailer/publishSigned \
  task/publishSigned \
  test/publishSigned \
  worker/publishSigned \
  oauth2/publishSigned \
  oauth2Controller/publishSigned \
  twitterController/publishSigned \
  standalone/publishSigned \
  scaldi/publishSigned \
  freemarker/publishSigned \
  thymeleaf/publishSigned \
  velocity/publishSigned \
  ++2.10.5 \
  clean \
  common/publishSigned \
  assets/publishSigned \
  httpClient/publishSigned \
  json/publishSigned \
  orm/publishSigned \
  factoryGirl/publishSigned \
  validator/publishSigned \
  framework/publishSigned \
  mailer/publishSigned \
  task/publishSigned \
  test/publishSigned \
  worker/publishSigned \
  oauth2/publishSigned \
  oauth2Controller/publishSigned \
  twitterController/publishSigned \
  standalone/publishSigned \
  scaldi/publishSigned \
  freemarker/publishSigned \
  thymeleaf/publishSigned \
  velocity/publishSigned
