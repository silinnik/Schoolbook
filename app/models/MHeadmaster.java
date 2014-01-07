package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Date: 12/26/13
 */
@Entity
@DiscriminatorValue("HEADMASTER")
public class MHeadmaster extends MUser {

}
