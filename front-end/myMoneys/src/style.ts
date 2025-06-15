import { definePreset } from '@primeng/themes';
import Aura from '@primeng/themes/aura';

export const MyPreset = definePreset(Aura, {
  name: 'custom',
  options: {
    primaryColor: '#ff5722', // Laranja
    secondaryColor: '#673ab7', // Roxo
    highlightBg: '#ffcc80', // Amarelo claro
  },

});


