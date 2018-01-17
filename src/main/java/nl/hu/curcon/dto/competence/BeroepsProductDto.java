package nl.hu.curcon.dto.competence;

import java.util.List;

import nl.hu.curcon.dto.BeoordelingsElementDto;

/**
 * Created by jayfeurich on 25/06/15.
 */
public class BeroepsProductDto extends BeoordelingsElementDto {

    private List<String[]> criterialinks;

    public List<String[]> getCriterialinks() {
        return criterialinks;
    }

    public void setCriterialinks(List<String[]> criterialinks) {
        this.criterialinks = criterialinks;
    }
}
