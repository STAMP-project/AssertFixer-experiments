import {Component} from '@angular/core';
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'bs-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
/**
 * Notification Component generates different Snackbars. The
 * duplication of code is on purpose for later give individal
 * behaviors to the different types.
 */
export class NotificationComponent {

  constructor(private snackBar: MatSnackBar) {
  }

  public httpError(error) {
    let msg;
    if (error.error && error.error.message) {
      msg = error.error.message;
    } else if (error.message) {
      msg = error.message;
    } else {
      msg = error;
    }

    this.snackBar.open(msg, null, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: 'snackbar-error',
      duration: 5000
    })
  }

  public error(message) {
    this.snackBar.open(message, null, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: 'snackbar-error',
      duration: 5000
    })
  }

  public ok(message) {
    this.snackBar.open(message, null, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: 'snackbar-ok',
      duration: 5000
    })
  }

  public warning(message) {
    this.snackBar.open(message, null, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: 'snackbar-warning',
      duration: 5000
    })
  }

  public info(message) {
    this.snackBar.open(message, null, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: 'snackbar-info',
      duration: 5000
    })
  }
}
