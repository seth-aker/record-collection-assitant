<template>
    <div v-show="active">
        <slot/>
    </div>
</template>

<script>
export default {
    name: 'CollectionDropdownContent',
    inject: ['sharedState'],
    computed: {
        active () {
            return this.sharedState.active
        }
    }
}
</script>

<style scoped>
div {
    position: absolute;

}
</style>