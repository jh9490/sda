<template>
<div>
  <MeetingForm @meeting-added="updateList" />
  <MeetingList :newItem="newMeeting"  />
</div>

</template>

<script>
export default {
  name: 'IndexPage',
  data(){
     return {
        newMeeting: {}
     }
  },
  methods : {
     updateList(e){
        this.newMeeting = e;
     }
  }
}
</script>
