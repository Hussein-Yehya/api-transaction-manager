package io.pismo.api.transaction.manager.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-07T01:25:12.942-03:00[America/Sao_Paulo]")

public class Transaction   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("account_id")
  private Long accountId;

  @JsonProperty("operation_type_id")
  private Long operationTypeId;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("event_date")
  private LocalDateTime eventDate;

  public Transaction id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Transaction id
   * @return id
  */
  @ApiModelProperty(readOnly = true, value = "Transaction id")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Transaction operationTypeId(Long operationTypeId) {
    this.operationTypeId = operationTypeId;
    return this;
  }

  /**
   * Get operationTypeId
   * @return operationTypeId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getOperationTypeId() {
    return operationTypeId;
  }

  public void setOperationTypeId(Long operationTypeId) {
    this.operationTypeId = operationTypeId;
  }

  public Transaction amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Transaction amount
   * @return amount
  */
  @ApiModelProperty(required = true, value = "Transaction amount")
  @NotNull

  @Valid

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Transaction eventDate(LocalDateTime eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  /**
   * Get eventDate
   * @return eventDate
  */
  @ApiModelProperty(readOnly = true, value = "")

  @Valid

  public LocalDateTime getEventDate() {
    return eventDate;
  }

  public void setEventDate(LocalDateTime eventDate) {
    this.eventDate = eventDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.accountId, transaction.accountId) &&
        Objects.equals(this.operationTypeId, transaction.operationTypeId) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.eventDate, transaction.eventDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountId, operationTypeId, amount, eventDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    operationTypeId: ").append(toIndentedString(operationTypeId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
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

