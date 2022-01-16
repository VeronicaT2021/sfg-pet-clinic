package guru.springfromework.sfgpetclinic.services.map;


import guru.springfromework.sfgpetclinic.model.Owner;
import guru.springfromework.sfgpetclinic.model.Pet;
import guru.springfromework.sfgpetclinic.services.OwnerService;
import guru.springfromework.sfgpetclinic.services.PetService;
import guru.springfromework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            // if the pet list is not null
            if (object.getPets() != null) {
                // iterate through the pet list
                // and create all the pets that does not exist
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        // create the pet type too if not exist
                        // (and set the new saved pet type in pet)
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    // create the pet
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
