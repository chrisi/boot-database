package net.gtidev.sandbox;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

public class MyDateDeserializer extends JsonDeserializer<Date> {
  @Override
  public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    String strDate = jsonParser.getValueAsString();
    try {
      return ISO8601Utils.parse(jsonParser.getValueAsString(), new ParsePosition(0));
    } catch (ParseException e) {
      throw new IOException("could not parse date '" + strDate + "':" + e.getMessage(), e);
    }
  }
}