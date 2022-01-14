package guru.springfromework.sfgpetclinic.services;

import guru.springfromework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
