<template>
<Card>
    <template #content>
        <div class="flex card-container align-items-center justify-content-center">
            <div class="flex-1 field">
                <h2>New Meeting</h2>
            </div>
            <div class="flex-1 field">
                <AutoComplete placeholder="Person Name" v-model="selectedPerson" :suggestions="filteredPersons" @complete="searchPerson($event)" field="name" />
            </div>
            <div class="flex-1 field">
                <AutoComplete placeholder="Location" v-model="selectedLocation" :suggestions="filteredLocations" @complete="searchLocation($event)" field="label" />
            </div>
            <div class="flex-1 field">
                <Calendar placeholder="Date" :maxDate="today" v-model="model.date" dateFormat="dd-mm-yy" />
            </div>
            <div class="flex-1 field">
                <Button label="Save" @click="save($event)" />
            </div>

        </div>
    </template>
</Card>
</template>

<script>
import InputText from 'primevue/inputtext';
import AutoComplete from 'primevue/autocomplete';
import Button from 'primevue/button';
import Calendar from 'primevue/calendar';
import Card from 'primevue/card';
import {
    apiUrl,
    geoQueryUrl
} from '../constants/api';
export default {
    name: 'IndexPage',
    components: {
        InputText,
        AutoComplete,
        Button,
        Calendar,
        Card
    },
    data() {
        return {
            today: new Date(),
            selectedLocation: null,
            filteredLocations: null,
            selectedPerson: null,
            filteredPersons: null,
            model: {
                location: null,
                person: null,
                date: null
            }
        }
    },
    methods: {
        async searchLocation(event) {
            if (event.query.length > 3) {
                const res = await this.$axios.$get(geoQueryUrl + event.query + '&fields=results.map_url');
                this.filteredLocations = res['data'];
            }
        },
        async searchPerson(event) {
            const res = await this.$axios.$get(apiUrl + 'person');
            this.filteredPersons = res;
        },
        async save(event) {
            this.model.person = (typeof this.selectedPerson === 'object') ? this.selectedPerson : {
                'id': -1,
                'name': this.selectedPerson
            };
            this.model.location = {
                'coordinates': this.selectedLocation.longitude + ',' + this.selectedLocation.latitude,
                'name': this.selectedLocation.label
            }

            const res = await this.$axios.$post(apiUrl + 'meeting', this.model);
            this.$emit('meeting-added', res);
            this.reset();
        },
        reset() {
            this.model = {
                location: null,
                person: null,
                date: null,
            }

            this.selectedLocation = null;
            this.selectedPerson = null;
        }
    }
}
</script>

<style scoped>
.p-autocomplete {
    width: 100% !important;
}
</style>
