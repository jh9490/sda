<template>
<div>
    <!-- <Card>
        <template #content>
            <div class="flex card-container align-items-center justify-content-center">
                <div class="flex-1 field">
                    <h2>Filter And Grouping</h2>
                </div>

               <div class="flex-1 field">
                <AutoComplete placeholder="Location" v-model="selectedLocation" :suggestions="filteredLocations" @complete="searchLocation($event)" field="label" />
            </div>
             <div class="flex-1 field">
                <Calendar placeholder="Search By Date Range"  selectionMode="range"  v-model="filter.dateRange" dateFormat="dd-mm-yy" />
            </div>
            <div class="flex-1 field">
                <AutoComplete placeholder="Search By Name" v-model="filter.personName" :suggestions="filteredPersons" @complete="searchPerson($event)" field="name" />
            </div>
            </div>
        </template>
 </Card> -->
    <DataTable  :value="meetingData" responsiveLayout="scroll">
        <Column field="id" header="ID"></Column>
        <Column field="location.name" header="Location"></Column>
        <Column field="person.name" header="Person"></Column>
        <Column field="date" header="Date">
            <template #body="slotProps">
                {{getDate(slotProps.data.date)}}
            </template>
        </Column>
    </DataTable>

</div>
</template>

<script>
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import ColumnGroup from 'primevue/columngroup';
import Checkbox from 'primevue/checkbox';
import Card from 'primevue/card';
import Calendar from 'primevue/calendar';
import AutoComplete from 'primevue/autocomplete';
import {
    apiUrl,
} from '../constants/api';
export default {
    props: ['newItem'],
    components: {
        ColumnGroup,
        Column,
        DataTable,
        Checkbox,
        Card,
        Calendar,
        AutoComplete
    },
    data() {
        return {
            meetingData: null,
            filter: {
               dateRange: "",
               personName: ""
            }
        }
    },
    watch: {
        'newItem': function (newVal, oldVal) {
            this.meetingData.push(newVal);
        },

    },
    async mounted() {
        await this.getData().then(data => this.meetingData = data);
    },
    methods: {
        getData(event) {
            return this.$axios.$get(apiUrl + 'meeting/list');
        },
        getDate(val) {
            return val.split("T")[0];
        }
    }

}
</script>
