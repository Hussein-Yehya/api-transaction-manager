package io.pismo.api.transaction.manager.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApiError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-06T16:53:21.626-03:00[America/Sao_Paulo]")

public class ApiError   {
  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("message")
  @Valid
  private List<String> message = null;

  @JsonProperty("cause")
  private String cause;

  @JsonProperty("error")
  private String error;

  @JsonProperty("status")
  private Integer status;

  public ApiError timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
  */
  @ApiModelProperty(example = "YYYY-MM-DDTHH:MM:SSZ", value = "")


  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public ApiError message(List<String> message) {
    this.message = message;
    return this;
  }

  public ApiError addMessageItem(String messageItem) {
    if (this.message == null) {
      this.message = new ArrayList<>();
    }
    this.message.add(messageItem);
    return this;
  }

  /**
   * Get message
   * @return message
  */
  @ApiModelProperty(example = "[\"Something wrong happened\"]", value = "")


  public List<String> getMessage() {
    return message;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }

  public ApiError cause(String cause) {
    this.cause = cause;
    return this;
  }

  /**
   * Get cause
   * @return cause
  */
  @ApiModelProperty(example = "Any exception", value = "")


  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  public ApiError error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(example = "Internal Server Error", value = "")


  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ApiError status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(example = "500", value = "")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.timestamp, apiError.timestamp) &&
        Objects.equals(this.message, apiError.message) &&
        Objects.equals(this.cause, apiError.cause) &&
        Objects.equals(this.error, apiError.error) &&
        Objects.equals(this.status, apiError.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, message, cause, error, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiError {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

