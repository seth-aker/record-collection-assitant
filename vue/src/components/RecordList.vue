<template>
  <div class="records">
      <record-view 
      v-for="curRecord in filteredRecords"
      :key="curRecord.id"
      :record="curRecord"
      />
  </div>
</template>

<script>
import RecordView from "./RecordView";

export default {
    name: "record-list",
    components: {
        RecordView
    },
    data() {
        return {

        }
    },
    computed: {
        filteredRecords() {
            return null;
        },
        newReleaseFilter() {
            return null;
        }
    }

}
</script>

<style>

</style>