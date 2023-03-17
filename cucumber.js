module.exports = {
    default: {
        formatOptions: {
            snippetInterface: 'synchronous',
        },
        publishQuiet: true,
        paths: ['src/test/resources/features/**/*.{feature,feature.md}'],
        require: ['src/test/js/step-definitions/**/*.(js)'],
    }
}
