package pl.edu.agh.pharmoptim.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Job results or job runtime error message
 */
@ApiModel(description = "Job results or job runtime error message")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-29T18:58:28.378Z[GMT]")
public class JobResultsOrError   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("population")
  private String population = null;

  @JsonProperty("newDf")
  private String newDf = null;

  @JsonProperty("error")
  private String error = null;

  public JobResultsOrError id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public JobResultsOrError population(String population) {
    this.population = population;
    return this;
  }

  /**
   * URL of the file with 59 parameters for each person (Population Data Frame)
   * @return population
  **/
  @ApiModelProperty(value = "URL of the file with 59 parameters for each person (Population Data Frame)")

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public JobResultsOrError newDf(String newDf) {
    this.newDf = newDf;
    return this;
  }

  /**
   * URL of the file with the newDF Data Frame
   * @return newDf
  **/
  @ApiModelProperty(value = "URL of the file with the newDF Data Frame")

  public String getNewDf() {
    return newDf;
  }

  public void setNewDf(String newDf) {
    this.newDf = newDf;
  }

  public JobResultsOrError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Error string
   * @return error
  **/
  @ApiModelProperty(value = "Error string")

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobResultsOrError jobResultsOrError = (JobResultsOrError) o;
    return Objects.equals(this.id, jobResultsOrError.id) &&
        Objects.equals(this.population, jobResultsOrError.population) &&
        Objects.equals(this.newDf, jobResultsOrError.newDf) &&
        Objects.equals(this.error, jobResultsOrError.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, population, newDf, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobResultsOrError {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("    newDf: ").append(toIndentedString(newDf)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
