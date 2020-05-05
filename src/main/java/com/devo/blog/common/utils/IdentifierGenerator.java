package com.devo.blog.common.utils;

import lombok.experimental.UtilityClass;

import static java.util.UUID.randomUUID;

@UtilityClass
public class IdentifierGenerator {

  public static String getNextPostUid() {
    return "p-" + getNextId();
  }

  public static String getNextId() {
    return randomUUID().toString();
  }

}
