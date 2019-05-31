package pl.edu.agh.pharmoptim.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Body
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-31T21:23:11.266Z[GMT]")
public class Body   {
  @JsonProperty("filename")
  @Valid
  private List<File> filename = null;

  public Body filename(List<File> filename) {
    this.filename = filename;
    return this;
  }

  public Body addFilenameItem(File filenameItem) {
    if (this.filename == null) {
      this.filename = new ArrayList<File>();
    }
    this.filename.add(filenameItem);
    return this;
  }

  /**
   * Get filename
   * @return filename
  **/
  @ApiModelProperty(value = "")
  @Valid
  public List<File> getFilename() {
    return filename;
  }

  public void setFilename(List<File> filename) {
    this.filename = filename;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.filename, body.filename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
