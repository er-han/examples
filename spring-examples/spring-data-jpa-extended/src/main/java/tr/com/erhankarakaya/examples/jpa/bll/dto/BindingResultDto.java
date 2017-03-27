package tr.com.erhankarakaya.examples.jpa.bll.dto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.List;

/**
 * Created by erhan.karakaya on 3/24/2017.
 */
public class BindingResultDto {
  private List<ObjectError> allErros;

  public List<ObjectError> getAllErros() {
    return allErros;
  }

  public void setAllErros(List<ObjectError> allErros) {
    this.allErros = allErros;
  }
}
