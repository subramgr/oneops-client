package com.oneops.client.util;

/**
 * Hello world!
 *
 */
public class OneopsAttributes {
  private String organization;
  private String assembly;
  private String environment;
  private String platform;

  public OneopsAttributes(String organization, String assembly, String environment,
    String platform) {
    super();
    this.organization = organization;
    this.assembly = assembly;
    this.environment = environment;
    this.platform = platform;
  }



  public static void main(String... args) {
    System.out.println("hello...");
    int l = args.length;

  }
}
