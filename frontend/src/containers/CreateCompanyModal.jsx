import React, { Component } from 'react';
import { Button, Form, FormGroup, FormText, Input, Label, Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';
import { FaPlus } from 'react-icons/fa';
import CompaniesApi from '../services/CompaniesApi';
import PropTypes from 'prop-types';

class CreateCompanyModal extends Component {
    constructor(props) {
        super(props);
        this.state = {
            orgNr: '',
            companyName: '',
            modal: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.toggle = this.toggle.bind(this);
        this.apiCreateCompany = this.apiCreateCompany.bind(this);
    }

    handleChange(event) {
        const name = event.target.name;
        const value = event.target.value;
        this.setState({ [ name ]: value });
    }

    toggle() {
        this.setState((prevState) => ({
            modal: !prevState.modal
        }));
    }

    async apiCreateCompany() {
        const company = {
            orgNr: this.state.orgNr,
            companyName: this.state.companyName
        };

        if (company.companyName) {
            await CompaniesApi.createNewCompany(company);
        } else {
            await CompaniesApi.createNewCompanyByOrgnr(company.orgNr);
        }

        // Inform parent component that new company has been created, if onCreated() defined in props
        if (typeof this.props.onCreated === 'function') {
            this.props.onCreated();
        }

        this.toggle();
    }

    render() {
        return (
            <>
                <Button color="primary" onClick={this.toggle}><FaPlus /> New company</Button>
                <Modal isOpen={this.state.modal} toggle={this.toggle}>
                    <ModalHeader toggle={this.toggle}>Create new company</ModalHeader>
                    <ModalBody>
                        <Form>
                            <FormGroup>
                                <Label for="orgNr">Orgnr</Label>
                                <Input
                                    type="text"
                                    name="orgNr"
                                    id="orgNr"
                                    placeholder="Valid orgNr, 9 digits"
                                    value={this.state.orgNr}
                                    onChange={this.handleChange} />
                            </FormGroup>
                            <FormGroup>
                                <Label for="orgNr">Name</Label>
                                <Input
                                    type="text"
                                    name="companyName"
                                    id="companyName"
                                    placeholder="Fancy name of your company"
                                    value={this.state.companyName}
                                    onChange={this.handleChange} />
                                <FormText color="muted">
                                    If you leave this field empty we will lookup company with orgNr in Brreg
                                </FormText>
                            </FormGroup>
                        </Form>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="secondary" onClick={this.toggle}>Cancel</Button>
                        <Button color="primary" onClick={this.apiCreateCompany}>Create</Button>
                    </ModalFooter>
                </Modal>
            </>
        );
    }
}

CreateCompanyModal.propTypes = {
    onCreated: PropTypes.func
};

export default CreateCompanyModal;
