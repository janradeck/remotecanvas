package de.janradeck.svgclient;

/*Generated by MPS */


public class SvgDrawerClient {
  private InjectionFactoryClient factory;
  public SvgDrawerClient(InjectionFactoryClient factory) {
    this.factory = factory;
  }

  public int draw(String message, String path, String style) {
    QueryGenerator query = factory.getQueryGenerator("/draw");
    query.addParameter("message", message);
    query.addParameter("path", path);
    query.addParameter("style", style);
    return query.executeGetQuery();
  }
  public int drawBlue(String message, String path) {
    QueryGenerator query = factory.getQueryGenerator("/drawBlue");
    query.addParameter("message", message);
    query.addParameter("path", path);
    return query.executeGetQuery();
  }
  public int drawGreen(String message, String path) {
    QueryGenerator query = factory.getQueryGenerator("/drawGreen");
    query.addParameter("message", message);
    query.addParameter("path", path);
    return query.executeGetQuery();
  }
  public int drawRed(String message, String path) {
    QueryGenerator query = factory.getQueryGenerator("/drawRed");
    query.addParameter("message", message);
    query.addParameter("path", path);
    return query.executeGetQuery();
  }
  public int drawBlack(String message, String path) {
    QueryGenerator query = factory.getQueryGenerator("/drawBlack");
    query.addParameter("message", message);
    query.addParameter("path", path);
    return query.executeGetQuery();
  }
  public int drawGrey(String message, String path) {
    QueryGenerator query = factory.getQueryGenerator("/drawGrey");
    query.addParameter("message", message);
    query.addParameter("path", path);
    return query.executeGetQuery();
  }
  public int clear() {
    QueryGenerator query = factory.getQueryGenerator("/clear");
    return query.executeGetQuery();
  }

}
