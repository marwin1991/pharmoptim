package pl.edu.agh.pharmoptim.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * JobParams
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-05-29T18:58:28.378Z[GMT]")
public class JobParams   {
  @JsonProperty("oralDose")
  private Integer oralDose = null;

  @JsonProperty("infDose")
  private Integer infDose = null;

  @JsonProperty("infTime")
  private Integer infTime = null;

  @JsonProperty("individualCount")
  private Integer individualCount = null;

  @JsonProperty("femaleCount")
  private Integer femaleCount = null;

  @JsonProperty("minAge")
  private Integer minAge = null;

  @JsonProperty("maxAge")
  private Integer maxAge = null;

  @JsonProperty("tEnd")
  private Integer tEnd = null;

  @JsonProperty("seed")
  private Integer seed = null;

  public JobParams oralDose(Integer oralDose) {
    this.oralDose = oralDose;
    return this;
  }

  /**
   * Oral bolus dose [mg]
   * @return oralDose
  **/
  @ApiModelProperty(value = "Oral bolus dose [mg]")

  public Integer getOralDose() {
    return oralDose;
  }

  public void setOralDose(Integer oralDose) {
    this.oralDose = oralDose;
  }

  public JobParams infDose(Integer infDose) {
    this.infDose = infDose;
    return this;
  }

  /**
   * Intravenous dose
   * @return infDose
  **/
  @ApiModelProperty(value = "Intravenous dose")

  public Integer getInfDose() {
    return infDose;
  }

  public void setInfDose(Integer infDose) {
    this.infDose = infDose;
  }

  public JobParams infTime(Integer infTime) {
    this.infTime = infTime;
    return this;
  }

  /**
   * Infusion time
   * @return infTime
  **/
  @ApiModelProperty(value = "Infusion time")

  public Integer getInfTime() {
    return infTime;
  }

  public void setInfTime(Integer infTime) {
    this.infTime = infTime;
  }

  public JobParams individualCount(Integer individualCount) {
    this.individualCount = individualCount;
    return this;
  }

  /**
   * Number of individuals
   * @return individualCount
  **/
  @ApiModelProperty(value = "Number of individuals")

  public Integer getIndividualCount() {
    return individualCount;
  }

  public void setIndividualCount(Integer individualCount) {
    this.individualCount = individualCount;
  }

  public JobParams femaleCount(Integer femaleCount) {
    this.femaleCount = femaleCount;
    return this;
  }

  /**
   * Number of females
   * @return femaleCount
  **/
  @ApiModelProperty(value = "Number of females")

  public Integer getFemaleCount() {
    return femaleCount;
  }

  public void setFemaleCount(Integer femaleCount) {
    this.femaleCount = femaleCount;
  }

  public JobParams minAge(Integer minAge) {
    this.minAge = minAge;
    return this;
  }

  /**
   * Minimal age
   * @return minAge
  **/
  @ApiModelProperty(value = "Minimal age")

  public Integer getMinAge() {
    return minAge;
  }

  public void setMinAge(Integer minAge) {
    this.minAge = minAge;
  }

  public JobParams maxAge(Integer maxAge) {
    this.maxAge = maxAge;
    return this;
  }

  /**
   * Maximal age
   * @return maxAge
  **/
  @ApiModelProperty(value = "Maximal age")

  public Integer getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(Integer maxAge) {
    this.maxAge = maxAge;
  }

  public JobParams tEnd(Integer tEnd) {
    this.tEnd = tEnd;
    return this;
  }

  /**
   * Simulation time [h]
   * @return tEnd
  **/
  @ApiModelProperty(value = "Simulation time [h]")

  public Integer getTEnd() {
    return tEnd;
  }

  public void setTEnd(Integer tEnd) {
    this.tEnd = tEnd;
  }

  public JobParams seed(Integer seed) {
    this.seed = seed;
    return this;
  }

  /**
   * Seed
   * @return seed
  **/
  @ApiModelProperty(value = "Seed")

  public Integer getSeed() {
    return seed;
  }

  public void setSeed(Integer seed) {
    this.seed = seed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobParams jobParams = (JobParams) o;
    return Objects.equals(this.oralDose, jobParams.oralDose) &&
        Objects.equals(this.infDose, jobParams.infDose) &&
        Objects.equals(this.infTime, jobParams.infTime) &&
        Objects.equals(this.individualCount, jobParams.individualCount) &&
        Objects.equals(this.femaleCount, jobParams.femaleCount) &&
        Objects.equals(this.minAge, jobParams.minAge) &&
        Objects.equals(this.maxAge, jobParams.maxAge) &&
        Objects.equals(this.tEnd, jobParams.tEnd) &&
        Objects.equals(this.seed, jobParams.seed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oralDose, infDose, infTime, individualCount, femaleCount, minAge, maxAge, tEnd, seed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobParams {\n");
    
    sb.append("    oralDose: ").append(toIndentedString(oralDose)).append("\n");
    sb.append("    infDose: ").append(toIndentedString(infDose)).append("\n");
    sb.append("    infTime: ").append(toIndentedString(infTime)).append("\n");
    sb.append("    individualCount: ").append(toIndentedString(individualCount)).append("\n");
    sb.append("    femaleCount: ").append(toIndentedString(femaleCount)).append("\n");
    sb.append("    minAge: ").append(toIndentedString(minAge)).append("\n");
    sb.append("    maxAge: ").append(toIndentedString(maxAge)).append("\n");
    sb.append("    tEnd: ").append(toIndentedString(tEnd)).append("\n");
    sb.append("    seed: ").append(toIndentedString(seed)).append("\n");
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
