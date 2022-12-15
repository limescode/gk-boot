package pl.limescode.gkboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found such product.")
public class NotFoundException extends RuntimeException {
}
