package pl.edu.agh.pharmoptim.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@ApiModel(description = "Job id or job creation error message")
public class JobIdOrError   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("error")
  private String error = null;

  public JobIdOrError error(String error) {
    this.error = error;
    return this;
  }

  public JobIdOrError id(Long id) {
    this.id = id;
    return this;
  }
}
